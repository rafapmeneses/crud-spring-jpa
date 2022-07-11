import "./header.style.css";
import { Button } from "../../components";
import { useNavigate } from "react-router-dom";
import { useUsuarioApi } from "../../../hooks/"
import { useCallback } from "react";
import logo from "../../../assets/img/cadastro.jpg";

export const Header = () => {

  const navigate = useNavigate();
  const useUsuario = useUsuarioApi();

  const handleLogout = useCallback(async () => {
    try {
      await useUsuario.postLogout();
    } catch (error) {
      console.log(error)
    }
  }, [useUsuario]);

  return (
    <div className="header__content">
      <img src={logo} alt="Icone" />
      <div className="header__buttons">
        <Button onClick={handleLogout}>Logout</Button>
      </div>
    </div> 
  );
};
