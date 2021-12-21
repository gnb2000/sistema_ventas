import React from 'react';
import '../Card/card.css';

function Card(props){
    console.log(props);
    return(
        <>
            <div className={"card text-white "+props.style}>
                <div className="card-body p-4 text-center">
                    <h5 className="card-title">{props.title}</h5>
                    <p className="card-text">{props.description}</p>
                </div>
            </div>
        </>
    )
}

export default Card;