// Modules
import { BrowserRouter, Routes, Route } from "react-router-dom";

// Containers
import ListContainer from "./containers/ListContainer";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/business" element={<ListContainer route='business' />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
