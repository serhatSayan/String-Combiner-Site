import logo from './logo.svg';
import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
import Layout from './components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './components/home/Home';


function App() {

  //girdileri ve son birleşik kelimeyi saklamak için
  const [girdiler, setGirdiler] = useState();
  const [lastBirlesik, setLastBirlesik] = useState();



  const getGirdiler = async () =>{

    try{
      const response = await api.get("/girdiler/getAll");

      //console.log(response.data);

      setGirdiler(response.data);

    } catch(err){
      console.log(err)
    }

  }

  const getLastBirlesik = async () =>{
    try{
      const response = await api.get("/birlesik/last");

      //console.log(response.data);

      setLastBirlesik(response.data);

    } catch(err){
      console.log(err)
    }
  }

  //uygulama çalıştığında getMovies çalışsın
  useEffect(() => {
    getGirdiler();
    getLastBirlesik();
  },[])

  return (
    <div className="App">
      
      <Routes>
        <Route path='/' element={<Layout/>}>
          <Route path='/' element={<Home girdiler={girdiler} lastBirlesik={lastBirlesik} 
          setGirdiler={setGirdiler} setLastBirlesik={setLastBirlesik}/>}></Route>
        </Route>
      </Routes>

    </div>
  );
}

export default App;
