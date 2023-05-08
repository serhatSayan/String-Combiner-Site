import './GirdiSec.css'

const GirdiSec = ({girdiler}) => {

    console.log(girdiler)

    return (
        <div className='girdiSec'>
            <ul>
                {
                    girdiler?.map( girdi =>{

                        return(
                            <li key={girdi.id}>
                            {girdi.girdiMetin}
                            </li>
                        )

                    })
                }
            </ul>
        </div>
    )

}

export default GirdiSec