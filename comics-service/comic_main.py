import flask
import random
import urllib2, json

app = flask.Flask(__name__)


@app.route('/get-comic')
def get_comic():
    num = random.randint(1,1929)
    final_url = "https://xkcd.com/%d/info.0.json" % num

    req = urllib2.Request(final_url)
    opener = urllib2.build_opener()
    f = opener.open(req)
    jsonfinal = json.loads(f.read())
   
    return jsonfinal["img"]


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=60002)