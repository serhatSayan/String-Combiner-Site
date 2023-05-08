import { useEffect, useRef, useState } from "react";
import api from "../../api/axiosConfig";
import { useParams } from "react-router-dom";
import { Container, Row, Col } from "react-bootstrap";

import GirdiForm from "../girdiForm/GirdiForm";
import AddGirdiInput from "../addGirdiInput/AddGirdiInput";

import React from "react";


const GirdiFormSec = ({girdiler, lastBirlesik, setGirdiler, setLastBirlesik}) => {

    const labelText = "Girdi ";

    const girdText = useRef();

    //yeni input field eklemek için
    const [listId, setListId] = useState(2);
    const [formData, setFormData] = useState({
            inputGirdiler:[{listId: 0, girdiMetin:""}, {listId: 1, girdiMetin:""}]
    });

    const addInputField = () =>{
        setFormData({...formData, inputGirdiler: [
            ...formData.inputGirdiler, {
                girdiMetin:"",
                listId:listId
            }
        ]})
        setListId(listId+1)
    }

    const renderInputFields = formData.inputGirdiler.map( inputGirdi => <AddGirdiInput
        key={inputGirdi.listId}
        labelText={labelText}
        listId={listId - 1}
        
    />)

    //birden fazla girdi olduğu için sorun çıkaracak
    const addGirdi = async (e) =>{
        e.preventDefault();

        const gird = girdText.current;

        const inputGirdiler = [];
        for(let elem of gird.elements){
            if(elem.value != null && elem.value != "") inputGirdiler.push({girdiMetin:elem.value});
        }

        console.log(inputGirdiler);

        try
        {
            const response = await api.post("girdiler/postMetin",inputGirdiler);
            
            //
            const updatedGirdiler = [...girdiler, {body:gird.value}];
            
            for(let elem of gird.elements){
                elem.value = "";
            }
    
            setGirdiler(updatedGirdiler);
        }
        catch(err)
        {
            console.error(err);
        }
    }

    //Birleştirme işlemi için API call
    const getBirlestir = async (e) =>{
        e.preventDefault();

        try {
            const response = await api.get("/birlesik/birlestir")

            if(response.data != null) setLastBirlesik(response.data)
        } catch (err) {
            console.error(err);
        }
    }

    return (
        <div className="girdiFormSec">
            <GirdiForm handleSubmit={addGirdi} girdText={girdText} labelText={labelText} 
            addInputField={addInputField} renderInputFields={renderInputFields} handleBirlestir={getBirlestir}/>
        </div>
    )
}

export default GirdiFormSec