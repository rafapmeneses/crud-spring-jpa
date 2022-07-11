import "./App.css";
import React from "react";
import { AllRoutes } from "./routes/index";
import './assets/styles/variables.css';

const App = () => {
  return (
    <div className="app">
      <AllRoutes />
    </div>
  );
};

export default App;
