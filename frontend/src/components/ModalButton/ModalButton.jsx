import React from 'react';

function ModalButton(props){

    return (
        <button type="button" class={"btn "+props.styles} data-bs-toggle="modal" data-bs-target={"#"+props.modalName}>
            {props.title}
        </button>
    )
}

export default ModalButton;