import { Navigate } from "react-router-dom";
import { useGlobalUser } from "../../../context";

export const Privada = ({ children }) => {
  const [user] = useGlobalUser();

  if (user?.token) {
    return (
      <>
        {children}
      </>
    )
  } else {
    return <Navigate to="/login" />;
  }
};
