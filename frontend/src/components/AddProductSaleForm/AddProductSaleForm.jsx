import axios from 'axios';
import React, { useEffect, useState } from 'react';
import {useParams,  useSearchParams } from 'react-router-dom';


function AddProductSaleForm(props){

    const [products,setProducts] = useState([]);
    const [productSelected,setProductSelected] = useState("");
    const [specificProduct,setSpecificProduct] = useState("");
    const [amount,setAmount] = useState(0);
    let params = useParams();


    useEffect(() => {
        axios.get("http://localhost:8080/productos")
            .then(res => {
                setProducts(res.data);
            })

        
    },[])

    useEffect(() => {
        axios.get("http://localhost:8080/producto/"+productSelected)
            .then(res => {
                setSpecificProduct(res.data);
            })
    },[productSelected])

    function handleProductChange(e){
        setProductSelected(e.target.value);
    }

    function handleAmountChange(e){
        setAmount(e.target.value);
    }

    function handleSubmit(e){
        e.preventDefault();
        console.log(specificProduct);
        axios.put("http://localhost:8080/itemVenta/"+specificProduct.codigo+"/"+params.id+"/"+amount)
            .then(res => {
                window.location.reload(true);
            })

    }

    

    return(
        <>
            <form onSubmit={handleSubmit}>
                <div class="mb-3">
                    <label class="form-label">Choose a product</label>
                    <select onChange={handleProductChange} value={productSelected} class="form-select">
                        <option>Open this select menu</option>
                        {products.map(product => {
                            return (
                                <option value={product.codigo}>{product.nombre}</option>
                            )
                        })}
                    </select>
                </div>
                {specificProduct !== ""? 
                    <>
                        <div class="mb-3">
                            <p><span className="fw-bold">Product:</span> {specificProduct.nombre}</p>
                            <label>Choose an amount</label>
                            <input type="range" onChange={handleAmountChange} class="form-range" value={amount} min="0" max={specificProduct.cantidad} id="customRange2"/>
                        </div>
                        <button className="btn btn-success" type="submit">Add</button>
                    </>
                :null}
                

            </form>
        </>
    )

}

export default AddProductSaleForm;