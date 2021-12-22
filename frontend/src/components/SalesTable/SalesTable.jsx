import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Modal from '../Modal/Modal';
import ModalButton from '../ModalButton/ModalButton';
import SaleProduct from '../SaleProduct/SaleProduct';

function SalesTable(){

    const [sales,setSales] = useState([]);
    const [itemsVenta, setItemsVenta] = useState([]);
    const [productos,setProductos] = useState([]);
    const [salesWithProducts,setSalesWithProducts] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8080/ventas")
            .then(res => {
                setSales(res.data);
            })
            .catch(e => {
                console.log(e);
            })
    },[])

    useEffect(() => {
        sales.map(async sale => {
            let data = {
                sale:sale,
                saleItem:[]
            }
            var itemsVentaAPI = await axios("http://localhost:8080/itemsVenta/"+sale.id);
            var itemsVenta = itemsVentaAPI.data;
            data.saleItem = itemsVenta;
            setSalesWithProducts(salesWithProducts => [...salesWithProducts,data]);
        })
    },[sales])

    

    return (
        <>
            <table class="table text-center">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Date</th>
                        <th scope="col">Total</th>
                        <th scope="col">Products</th>
                    </tr>
                </thead>
                <tbody>
                    {salesWithProducts.map(sale => {
                        console.log(sale);
                        console.log(sale.product);
                        return (
                            <tr key={sale.sale.id}>
                                <th scope="row">{sale.sale.id}</th>
                                <td>{sale.sale.fecha}</td>
                                <td>$ {sale.sale.total}</td>
                                <td>
                                    {salesWithProducts.length !== 0 ? 
                                        <>
                                            <ModalButton styles="bg-success text-white" modalName="saleProducts" title="Details"/>
                                            <Modal modalName="saleProducts" title="Details" component={<SaleProduct itemsVenta={sale.saleItem} />}/>
                                        </>
                                    : null}
                                </td>
                            </tr>
                        )
                    })}
                    
                </tbody>
            </table>
        </>
    )
}

export default SalesTable;