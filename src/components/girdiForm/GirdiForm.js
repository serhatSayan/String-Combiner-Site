import { Form, Button, FormGroup , Row, Col} from "react-bootstrap";
import './GirdiForm.css';

const GirdiForm = ( {handleSubmit, girdText, labelText, defaultValue, addInputField, renderInputFields ,handleBirlestir} ) => {
    return (
        <Form ref={girdText}>
            <Row>
                {renderInputFields}
            </Row>
            <Row>
                <div className="butonlar">
                    <Button  onClick={handleSubmit}>Kaydet</Button>
                    <Button onClick={handleBirlestir}>Birleştir</Button>
                    <Button onClick={addInputField}>Ekle</Button>
                </div>
            </Row>
        </Form>
    )
}

export default GirdiForm