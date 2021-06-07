import os
from flask import Flask
app = Flask(__name__)
color = os.environ.get('COLOR')
@app.route("/")
def main():
    return "<h1>Welcome! This app is running in a container!\n</h1>"

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8080)
