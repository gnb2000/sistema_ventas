import axios from 'axios';
import React, { useEffect, useState } from 'react';

function SaleProduct(props){

    const [productos, setProductos] = useState([]);
    const [itemsVenta, setItemsVenta] = useState([]);

    useEffect(() => {        
        setItemsVenta(props.itemsVenta);
    },[props.itemsVenta])

    useEffect(() => {
        itemsVenta.map(async item => {
            let nuevo = {
                item:item,
                producto:""
            }

            var productoAPI = await axios("http://localhost:8080/producto/"+item.idProducto);
            var producto = productoAPI.data;
            nuevo.producto = producto;

            setProductos(productos => [...productos,nuevo]);
        })
    },[itemsVenta])

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
                    {productos.length !== 0 ? productos.map(producto => {
                        return (
                            <tr key={producto.producto.codigo}>
                                <th scope="row">{producto.producto.codigo}</th>
                                <td>{producto.producto.nombre}</td>
                                <td>$ {producto.producto.precio}</td>
                                <td>{producto.item.cantidad}</td>
                            </tr>
                        )
                    }) : null}
                </tbody>
            </table>
        </>
    )



}

export default SaleProduct;