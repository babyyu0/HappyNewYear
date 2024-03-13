// Modules
import { BrowserRouter, Routes, Route } from "react-router-dom";

// Containers
import BusinessContainer from "./containers/BusinessContainer";
import "./css/Global.css"

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/business" element={<BusinessContainer />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
