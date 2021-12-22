import React, { useState } from 'react';
import axios from 'axios';

function NewProductForm(){

    const [name,setName] = useState("");
    const [cost,setCost] = useState("");
    const [amount,setAmount] = useState("");

    function handleNameChange(e){
        setName(e.target.value);
    }

    function handleCostChange(e){
        setCost(e.target.value);
    }

    function handleAmountChange(e){
        setAmount(e.target.value);
    }

    function handleSubmit(e){
        e.preventDefault();
        axios.post("http://localhost:8080/producto/"+name+"/"+cost+"/"+amount)
            .then(res => {
                window.location.reload(true);
            })
    }


    return (
        <>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label className="form-label">Name</label>
                    <input type="text" onChange={handleNameChange} class="form-control" id="name"/>
                </div>
                <div className="mb-3">
                    <label className="form-label">Cost</label>
                    <input type="text" onChange={handleCostChange} class="form-control" id="cost"/>
                </div>
                <div className="mb-3">
                    <label className="form-label">Amount</label>
                    <input type="text" onChange={handleAmountChange} class="form-control" id="amount"/>
                </div>
                <button type="submit" class="btn btn-success">Create</button>
            </form>
        </>
    )
}

export default NewProductForm;