// created a list that stores the path of all images
availableImages = ['Pictures/blue-monster.jpg', 'Pictures/Doraemon.jpeg', 'Pictures/Doremi.jpg', 'Pictures/Mickey.png', 'Pictures/Mouse.jpeg', 'Pictures/Phineas.png', 'Pictures/Pikachu.png', 'Pictures/shin.jpeg', 'Pictures/blue-monster.jpg', 'Pictures/Doraemon.jpeg', 'Pictures/Doremi.jpg', 'Pictures/Mickey.png', 'Pictures/Mouse.jpeg', 'Pictures/Phineas.png', 'Pictures/Pikachu.png', 'Pictures/shin.jpeg']

function start() {
    let moves = 0;
    let firstImg = null;
    let secondImg = null;
    const maindiv = document.getElementById("boardgame");
    while (maindiv.firstChild) {
        maindiv.removeChild(maindiv.lastChild);
    }
    const scorediv = document.getElementById("score");
    while (scorediv.firstChild) {
        scorediv.removeChild(scorediv.lastChild);
    }
    // Create a copy of Images
    var row = document.createElement('div')
    ImagesCopy = JSON.parse(JSON.stringify(availableImages))
    // run a loop for 16 images
    for (let j = 1; j <= 16; j++) {
        var div = document.createElement('div');
        div.setAttribute('class', 'imgdiv')
        var image = document.createElement('img')
        randomImg = ImagesCopy.splice(Math.floor(Math.random() * ImagesCopy.length), 1);
        image.setAttribute('src', randomImg);
        image.setAttribute('class', 'hide')
        div.appendChild(image)
        row.appendChild(div);

        if (j % 4 == 0) {
            document.getElementById('boardgame').append(row)
            row = document.createElement('div')
        }

        div.addEventListener('click', function (event) {
            moves++;
            if (event.currentTarget.children[0].classList.contains("showimg")) return
            firstImg = secondImg
            secondImg = event.currentTarget.children[0]
            secondImg.classList.add("showimg")
            if (firstImg != null) {
                if (firstImg.src != secondImg.src) {
                    setTimeout(function () {
                        firstImg.classList.remove("showimg");
                        secondImg.classList.remove("showimg");
                        firstImg = secondImg = null;
                    }, 300);
                } else
                    firstImg = secondImg = null;
            }

            if (document.getElementsByClassName('showimg').length == 16) {
                setTimeout(function () {
                    alert("You won !!! ")
                }, 1000);
                
                let button = document.createElement('button');
                button.setAttribute('class', 'btn btn-warning');
                let node = document.createTextNode("You won!!! Moves " + moves);
                button.appendChild(node)
                document.getElementById('score').appendChild(button)
            }

        })
    }
}