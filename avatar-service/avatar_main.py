import flask
import random

app = flask.Flask(__name__)


@app.route('/get-avatar')
def get_avatar():
    names = ["sanyi", "akos", "deb", "gab", "mark"]

    name = random.choice(names)

    data = {
        'avatar': "https://robohash.org/%s" % name
    }

    return data["avatar"]


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=60003)