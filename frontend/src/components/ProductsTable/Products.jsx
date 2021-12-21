import React, { useEffect, useState } from 'react';
import axios from 'axios';

function Products(){

    const [products,setProducts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/productos")
            .then(res => {
                setProducts(res.data);
                console.log(res.data);
            })
            .catch(e => {
                console.log(e);
            })

    },[])

    return (
        <>
            <table class="table text-center">
                <thead>
                    <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Cost</th>
                    <th scope="col">Amount</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map(product => {
                        return (
                            <tr key={product.codigo}>
                                <th scope="row">{product.codigo}</th>
                                <td>{product.nombre}</td>
                                <td>$ {product.precio}</td>
                                <td>{product.cantidad}</td>
                            </tr>
                        )
                    })}
                    
                </tbody>
            </table>
        </>
    )
}

export default Products;
