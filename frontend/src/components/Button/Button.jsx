import React from 'react';

function Button(props){

    return(
        <button className={"btn me-md-2 "+props.styles}>
            {props.title}
        </button>
    )
}

export default Button;