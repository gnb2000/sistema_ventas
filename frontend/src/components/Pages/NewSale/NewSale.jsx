import axios from 'axios';
import React, { useEffect, useState } from 'react';
import AddProductSaleForm from '../../AddProductSaleForm/AddProductSaleForm';
import {useNavigate, useParams,  useSearchParams } from 'react-router-dom';
import SaleProduct from '../../SaleProduct/SaleProduct';

function NewSale(){

    const [currentDate,setCurrentDate] = useState(new Date().toISOString().slice(0, 10));
    const [sale,setSale] = useState([]);
    const [itemsVenta,setItemVenta] = useState([]);
    let params = useParams();
    let history = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8080/itemsVenta/"+params.id)
            .then(res => {
                setItemVenta(res.data);
            })
    },[])

    function deleteSale(){
        console.log(sale);
        console.log("hola");
        axios.delete("http://localhost:8080/venta/"+params.id)
            .then(res => {
                history("/");
            })
    }

    return (
        <div className="container pt-4">
            <h2 className="text-center">New sale</h2>
            <h5 className="text-center">Date: {currentDate}</h5>
            <div className="row">
                <div className="col-6 bg-light mt-5 shadow p-4">
                    <AddProductSaleForm saleId={sale.id}/>
                </div>
                <div className="col-6  mt-5 shadow p-4">
                    <SaleProduct itemsVenta={itemsVenta}/>
                </div>
                
            </div>
            <div className="d-flex justify-content-center mt-5">
                    <button onClick={() => deleteSale()} className="btn btn-danger me-2">Cancel</button>
                    <a href="/" type="button" className="btn btn-success">Finish</a>
                </div>
        </div>
    )
}

export default NewSale;