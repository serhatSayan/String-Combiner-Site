import GirdiSec from "../girdiSec/GirdiSec";
import GirdiFormSec from "../girdiFormSec/GirdiFormSec";
import BirlesikSec from "../birlesikSec/BirlesikSec"
import { Container, Row, Col } from "react-bootstrap";

const Home = ({girdiler, lastBirlesik, setGirdiler, setLastBirlesik}) => {
    return (
        <Container>
            <Row>
                <Col>
                    <GirdiFormSec girdiler={girdiler} setGirdiler={setGirdiler} lastBirlesik={lastBirlesik}
                    setLastBirlesik={setLastBirlesik}/>
                </Col>
                <Col>
                    <Row>
                        <GirdiSec girdiler={girdiler}/>
                    </Row>
                    <Row>
                        <BirlesikSec lastBirlesik={lastBirlesik} />
                    </Row>
                </Col>
            </Row>

        </Container>
        
    )

}

export default Home