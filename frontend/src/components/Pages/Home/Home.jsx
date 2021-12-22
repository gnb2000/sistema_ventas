import React, { useEffect, useState } from 'react';
import Card from '../../Card/Card';
import './home.css';
import axios from 'axios';
import {Navigate, useNavigate} from 'react-router-dom';


function Home(){

    const [currentDate,setCurrentDate] = useState(new Date().toISOString().slice(0, 10));
    const [sale,setSale] = useState([]);
    let history = useNavigate();

    function createNewSale(){
        axios.post("http://localhost:8080/venta/"+currentDate+"/0")
            .then(res => {
                history("/newSale/"+res.data.id);
            })
    }

    return (
        <>
            <div className="d-flex justify-content-center align-items-center height">
                <div className="p-2">
                    <a href="/products" type="button">
                        <Card title="Products" style="bg-primary" description="List of products"/>
                    </a>
                </div>
                <div className="p-2">
                    <a href="/sales" type="button">
                        <Card title="Sales" style="bg-success" description="List of sales"/>
                    </a>
                </div>
                <div className="p-2">
                    <a onClick={() => createNewSale()} type="button">
                        <Card title="New sale" style="bg-danger" description="Create a new sale"/>
                    </a>
                </div>
            </div>
        </>
    )
}

export default Home;