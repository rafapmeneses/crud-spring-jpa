import { useMemo } from "react";
import { useHttp } from "../_base/use-http.hook";
import { BASE_URL } from "../../constants/index";
import { useGlobalUser } from "../../context";
import { useNavigate } from "react-router-dom";

export const useUsuarioApi = () => {

  const [globalUser, setGlobalUser] = useGlobalUser();
  const navigate = useNavigate();

  const httpInstance = useHttp(BASE_URL, {
    ["x-auth-token"]: globalUser.token
  });

  const defaultInstance = useHttp(BASE_URL);

  const getBuscarUsuarios = async () => {
    return await httpInstance.get("/listar");
  };

  const getBuscarUsuario = async (id) => {
    return await httpInstance.get(`/listar/${id}`);
  };

  const putEditarUsuario = async (body, id) => {
    await httpInstance.put(`atualizar/${id}`, body);
  };

  const delDeletarUsuario = async (id) => {
    await httpInstance.del(`deletar/${id}`);
  };

  async function postCreateUser(body){
    await defaultInstance.post("/cadastrar", body);
    const login = {
      email: body.email,
      password: body.senha
    }
    await postLogin(login)
  };

  async function postLogin({email, password}){
    const token = await defaultInstance.postLogin("/login",
      {},
      {auth:{ username: email, password }}
    );
    if (token) {
      setGlobalUser({token});
    }
  };

  async function postLogout(){
    setGlobalUser({token:""});
    await httpInstance.post("/logout");
    navigate('/login')
  };
  
  return useMemo(
    () => ({
      getBuscarUsuarios,
      getBuscarUsuario,
      putEditarUsuario,
      delDeletarUsuario,
      postCreateUser,
      postLogin,
      postLogout
    }),
    // eslint-disable-next-line react-hooks/exhaustive-deps
    []
  );
};
