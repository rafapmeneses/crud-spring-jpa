import "./registrar.style.css";
import {Button, Header, Footer} from '../../components'
import { useState } from "react";
import { useUsuarioApi } from "../../../hooks";
import { useNavigate } from "react-router-dom"; 

const INITIAL_USER_INFO = {
  nome: "",
  email: "",
  senha: "",
};

export const Registrar = () => {

  const [userInfo, setUserInfo] = useState(INITIAL_USER_INFO);
  const { postCreateUser } = useUsuarioApi();
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await postCreateUser(userInfo);
      navigate("/")
    } catch (error) {
      console.log(error)
    }
  };

  const handleUserInfo = (event) => {
    const { name, value } = event.target;
    setUserInfo({ ...userInfo, [name]: value });
  };

  const handleNavigateToLogin = () => {
    navigate("/login");
  };

  return (
    <div className="register__main-screen">
      <h1>Cadastre-se no CRUD JPA</h1>
      <img src="" alt="" />
      <form className="register__form" onSubmit={handleSubmit}>

        <label htmlFor="nome">Nome</label>
        <input 
          required
          onChange={handleUserInfo}
          id="nome"
          name="nome"
          value={userInfo.nome}
        /> 

        <label htmlFor="email">Email</label>
        <input
          required
          onChange={handleUserInfo}
          id="email"
          name="email"
          value={userInfo.email}
        />   

        <label htmlFor="senha">Senha</label>
        <input 
          required
          type="password"
          onChange={handleUserInfo}
          id="senha"
          name="senha"
          value={userInfo.senha}
        /> 

        <Button>Registrar</Button>
        <Button onClick={handleNavigateToLogin}>Já tenho uma conta</Button>
      </form>
    </div>
  );
};
