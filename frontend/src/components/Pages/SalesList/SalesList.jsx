import React from 'react';
import SalesTable from '../../SalesTable/SalesTable';
import RedirectHome from '../../RedirectHome/RedirectHome';


function SalesList(){

    return(
        <>
            <div className="d-flex justify-content-center mt-5">
                <RedirectHome/>
            </div>
            <div className="container pt-5">
                <SalesTable/>
            </div>
        </>
    )
}

export default SalesList;