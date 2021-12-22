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
import SalesList from './components/Pages/SalesList/SalesList';


function App() {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home/>}/>
        <Route path="/products" element={<ProductsList/>}/>
        <Route path="/sales" element={<SalesList/>}/>

        
      </Routes>
    </Router>
  );
}

export default App;
