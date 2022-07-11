import { Routes, Route, Navigate } from "react-router-dom";
import {
  Home,
  Login,
  Registrar,
  UserDetails
} from "../ui/screens";
import { Privada } from "../ui/components";

export const AllRoutes = () => {
  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/registrar" element={<Registrar />} />
      <Route path="/:userId" element={<Privada> <UserDetails/> </Privada>}/>
      <Route path="/" element={<Privada> <Home/> </Privada>}/>
      <Route path="*" element={<Navigate to="/"/>}/>
    </Routes>
  );
};
