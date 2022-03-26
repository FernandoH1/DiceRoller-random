import { number } from 'prop-types';
import React, { useState } from 'react'
import { connect } from 'react-redux';
import { fetchRandom } from '../actions';

const Form = (props) => {// component stateless
  const [state, setState] = useState();
 
  const onSubmit = (e) => {
    e.preventDefault();
    props.dispatch(fetchRandom(state));
  };
  
  return <div>
    <center>
    <form onSubmit={onSubmit}>
      <label htmlFor="list">Ingrese cantidad de Dados a lanzar:</label>
      <br />
      <input id="list" type="number" max="20" min="1" class="m-2"
        onChange={(e) => setState(e.target.value)}
      ></input>
      <br />
      <button type="submit" class="btn btn-primary m-2" disabled={props.loading}>
        Lanzar
      </button>
    </form>
    </center>
  </div>
}


const stateMapToPros = state => {
  return {
    loading: state.view.loading
  }
}


export default connect(stateMapToPros)(Form)
