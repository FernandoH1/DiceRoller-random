import React, { Component } from 'react'
import Form from '../components/Form'
import Result from '../components/Result'

class App extends Component {// component stateful
  render() {
    return (
      <div class="container-fluid">
        <center>
        <h3>Dice Roller</h3>
        <p>Sistema Ramdom de Dados</p>
        </center>
        <Form />
        <Result />
      </div>
    )
  }
}

export default App


