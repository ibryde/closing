let generate = document.getElementById("generate");
let clean = document.getElementById("clean");

generate.addEventListener("click", async () => {
    let response = await fetch("http://localhost:7123/generate", {
        method: "POST",
        body: JSON.stringify({
            path: "FIXME: Some code was deleted here"
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    })
    console.log(response);

})

clean.addEventListener("click", async () => {
    let response = await fetch("http://localhost:7123/clean")
    console.log(response);
})
