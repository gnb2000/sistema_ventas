import logo from './logo.svg';
import './App.css';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link
} from "react-router-dom";
import Home from './components/Pages/Home/Home';
import ProductsList from './components/Pages/ProductsList/ProductsList';


function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home/>}/>
        <Route path="/products" element={<ProductsList/>}/>
        
      </Routes>
    </Router>
  );
}

export default App;
