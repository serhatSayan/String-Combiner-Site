import {React, useState, useEffect} from 'react';
import { Stack, Form, Button, Container } from 'react-bootstrap'; 

const AddGirdiInput = (listId, labelText, defaultValue) => {
    return (
        <Form.Group className="mb-3" controlId={"girdiTextArea"+{listId}}>
            <Form.Label></Form.Label>
            <Form.Control as="textarea" rows={1} defaultValue={defaultValue} />
        </Form.Group>
    )
}

export default AddGirdiInput