from flask import Flask


app = Flask(__name__)


@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"


@app.route('/cars')
def list_cars():
    return {
        'cars': [
            {
                'id': 567,
                'make': 'Kia',
                'model': 'Sorento',
                'year': '2015',
                'km': 56789,
                'price': 12100,
                'transmission': 'Manual',
                'fuel': 'GPL',
                'seats': 7
            },
            {
                'id': 78,
                'make': 'Mega',
                'model': 'Cooper',
                'year': '2050',
                'km': 0,
                'price': 2345678000,
                'transmission': 'Quantum',
                'fuel': 'Plutonium',
                'seats': 100
            },
            {
                'id': 123,
                'make': 'Mini',
                'model': 'Cooper',
                'year': '2008',
                'km': 123456,
                'price': 8000,
                'transmission': 'Auto',
                'fuel': 'Diesel',
                'seats': 5
            }
        ],
        'test': 'whatever'
    }
