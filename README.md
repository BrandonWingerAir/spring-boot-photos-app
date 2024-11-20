### Photos Path:
<!-- --> http://localhost:8080/photos

### Photo Path:
<!-- --> http://localhost:8080/photos/1

### Upload Path:
<!-- --> http://localhost:8080/upload.html

### Download Path:
<!-- --> http://localhost:8080/photos/download/IMAGE_ID

### POST call (browser console):

```
(async function createPhoto() {
    let photo = { "filename": "post.jpg"};
    await fetch('http://localhost:8080/photos', {
    	method: "POST",
    	headers: {
    		Accept: 'application/json',
    		'Content-Type': 'application/json'
    	},
    	body: JSON.stringify(photo)
    }).then(result => result.text())
      .then(text => alert(text));
})();
```

### DELETE call (browser console):

```
(async function deletePhoto(id) {
await fetch('http://localhost:8080/photos/' + id, {
method: "DELETE"
})
})("1");
```