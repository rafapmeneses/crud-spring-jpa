import './user-details.style.css'
import { useUsuarioApi } from '../../../hooks'
import { useCallback, useEffect, useState } from 'react';
import { Button } from '../../components/'
import { useParams, useNavigate } from 'react-router-dom'

export function UserDetails ({userInformacoes}){
  const [user, setUser] = useState({});

  const userApi = useUsuarioApi();
  const {userId} = useParams();
  const navigate = useNavigate();

  const updateUser = useCallback(async () => {
    try{
      const userDetails = await userApi.getBuscarUsuario(userId)
      setUser(userDetails);
    }catch(error){
      console.log(error)
    }
  }, [userApi])

  useEffect(() => {
    updateUser()
  }, [updateUser])

  const handleAtualizar = async (evento) => {
    evento.preventDefault();
    await userApi.putEditarUsuario(user, user.id);
    updateUser();
  };

  const handleChange = (evento) => {
    const { value, name } = evento.target;

    setUser((valoresAntigo) => {
      return {
        ...valoresAntigo,
        [name]: value,
      };
    });
  };

  const handleApagar = async () =>{
    await userApi.delDeletarUsuario(user.id);
    navigate("/");
  }

  return (
    <div className="user-details__content">
      <form className="user-details__form" onSubmit={handleAtualizar}>
        <label htmlFor="">Email</label>
        <input type="text" value={user?.email} name="email" onChange={handleChange}/>
        <label htmlFor="">Nome</label>
        <input type="text" value={user?.nome} name="nome" onChange={handleChange}/>
        <Button>Atualizar</Button>
        <Button onClick={handleApagar}>Excluir</Button>
      </form>
    </div>
  )
}