import React from 'react';

function Modal(props){

    return(
        <>
            <div class="modal fade" id={props.modalName} tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">{props.title}</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        {props.component}
                    </div>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Modal;