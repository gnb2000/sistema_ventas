import React from 'react';
import Button from '../../Button/Button';
import Modal from '../../Modal/Modal';
import Products from '../../ProductsTable/Products';
import ModalButton from '../../ModalButton/ModalButton';
import NewProductForm from '../../NewProductForm/NewProductForm';
import RedirectHome from '../../RedirectHome/RedirectHome';



function ProductsList(){


    return(
        <>  
            <div className="d-flex justify-content-center mt-5">
                <RedirectHome/>
            </div>
            <div className="px-5">
                <div className="d-grid gap-2 pt-5 pb-4 d-md-flex justify-content-md-end">
                    <ModalButton styles="bg-success text-white" modalName="exampleModal" title="New product"/>
                    <Modal modalName="exampleModal" title="New Product" component={<NewProductForm/>}/>
                </div>
                <Products/>

            </div>
            
            
        </>
    )
}

export default ProductsList;