export const fetchRandom = (state) => (dispatch) => {

    dispatch({ type: "view-loading" });
    let list="";
    for(let i =0; i < state-1; i++){
        list+="0,";
    }
    list+="0";
    console.log("dados= "+list);
    return fetch(`http://localhost:8080/r`, {
        method: 'POST', 
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({list}) 
    }).then(response => response.json())
      .then(json => {
          dispatch({ type: "random-result", data: json });
          dispatch({ type: "view-loaded" });
        })
}

