import React from 'react';
import Card from '../../Card/Card';
import './home.css';

function Home(){

    return (
        <>
            <div className="d-flex justify-content-center align-items-center height">
                <div className="p-2">
                    <a href="/products" type="button">
                        <Card title="Products" style="bg-primary" description="List of products"/>
                    </a>
                </div>
                <div className="p-2">
                    <Card title="Sales" style="bg-success" description="List of sales"/>
                </div>
                <div className="p-2">
                    <Card title="New sale" style="bg-danger" description="Make a new sale"/>
                </div>
            </div>
        </>
    )
}

export default Home;