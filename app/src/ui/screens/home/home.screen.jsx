import { useEffect, useState, useCallback } from "react";
import { useNavigate } from "react-router-dom";
import { useUsuarioApi } from "../../../hooks";
import { Footer, Header, UserCard } from "../../components";
import "./home.style.css";

export const Home = () => {

  const useUsuario = useUsuarioApi();
  const navigate = useNavigate();
  const [usuarios, setUsuarios] = useState([]);
  const [userInformacoes, setUserInformacoes] = useState({});

  console.log(usuarios)

  const updateUsuarios = useCallback(async () => {
    try {
      const listaUsuarios = await useUsuario.getBuscarUsuarios();
      setUsuarios(listaUsuarios);
    } catch (error) {
      console.log(error)
    }
  }, [useUsuario]);

  useEffect(() => {
    updateUsuarios();
  },[updateUsuarios])

  const handleSetAtualizar = async (id) =>{
    console.log(id)
    navigate(`/${id}`)
  }

  return (
    <div className="home__content">
      <Header/>
      {
        usuarios?.map(usuario=>{
          return(
            <UserCard 
              user={usuario} 
              onClickUserDetails={handleSetAtualizar}
            />
          )
        })
      }
      <Footer/>
    </div>
  );
};
