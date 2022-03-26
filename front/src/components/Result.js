import React from 'react'
import { connect } from 'react-redux';
import dado1 from '../Dadoimg/dice1.png';
import dado2 from '../Dadoimg/dice2.png';
import dado3 from '../Dadoimg/dice3.png';
import dado4 from '../Dadoimg/dice4.png';
import dado5 from '../Dadoimg/dice5.png';
import dado6 from '../Dadoimg/dice6.png';

function getimgDado(elemento){
  switch(elemento){
    case "1":
        return dado1;
      break;
      case "2":
        return dado2;
      break;
      case "3":
        return dado3;
      break;
      case "4":
        return dado4;
      break;
      case "5":
        return dado5;
      break;
      case "6":
        return dado6;
      break;
  }
}

const Result = (props) => {
  let caras=[];
  console.log(props.result);
  if(props.result!=undefined){
    caras=props.result.split(",");
  }caras
  return <div>
    <center>
       {caras.map(function(elemento){
        return <img src={getimgDado(elemento)}></img>
       })}
    </center>
  </div>
}


const stateMapToPros = state => {
  return {
    result: state.random.result?.randomList
  }
}


export default connect(stateMapToPros)(Result)
