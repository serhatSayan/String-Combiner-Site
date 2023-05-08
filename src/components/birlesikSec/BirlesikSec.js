import './BirlesikSec.css';

const BirlesikSec = ({lastBirlesik}) => {

    console.log(lastBirlesik);

    return (
        <div className="birlesikSec">
            <h6>Son birleştirilen dizi: {lastBirlesik?.birlesikMetin} </h6>
            <h6>Birleştirme süresi: {lastBirlesik?.sure} </h6>
        </div>
    )

}

export default BirlesikSec