import "./login.style.css";
import {Button, Header, Footer} from '../../components';
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useUsuarioApi } from "../../../hooks/";

const INITIAL_USER_INFO = {
  email: "",
  password: "",
};

export const Login = () => {

  const [userInfo, setUserInfo] = useState(INITIAL_USER_INFO);
  const { postLogin } = useUsuarioApi();
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await postLogin(userInfo);
      navigate("/");
    } catch (error) {
      console.log(error)
    }
  };

  const handleUserInfo = (event) => {
    const { name, value } = event.target;
    setUserInfo({ ...userInfo, [name]: value });
  };

  const handleNavigateToRegister = () => {
    navigate("/registrar");
  };

  return (
    <div className="login__main-screen">
      <h1>CRUD JPA</h1>
      <img src="" alt="" />

      <form className="login__form" onSubmit={handleSubmit}>
        <label htmlFor="email">Email</label>
        <input 
          required
          onChange={handleUserInfo}
          id="email"
          name="email"
          value={userInfo.email}
        />   

        <label htmlFor="password">Senha</label>
        <input 
          required
          type="password"
          onChange={handleUserInfo}
          id="password"
          name="password"
          value={userInfo.password}
        /> 

        <Button>Login</Button>
        <Button onClick={handleNavigateToRegister}>Não tenho conta</Button> 
      </form>
    </div>
  );
};
