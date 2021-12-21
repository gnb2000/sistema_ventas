import React from 'react';
import Button from '../../Button/Button';
import Modal from '../../Modal/Modal';
import Products from '../../ProductsTable/Products';
import ModalButton from '../../ModalButton/ModalButton';


function ProductsList(){


    return(
        <>  
            <div className="p-5">
                <div className="d-grid gap-2 pt-5 pb-4 d-md-flex justify-content-md-end">
                    <ModalButton styles="bg-success text-white" modalName="exampleModal" title="New product"/>
                    <Modal modalName="exampleModal" title="New Product"/>
                </div>
                <Products/>

            </div>
            
            
        </>
    )
}

export default ProductsList;