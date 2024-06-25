FROM python:3.11.9

WORKDIR /flask

COPY ./ /flask

RUN pip install -r requirements.txt

EXPOSE 9456

CMD ["python3", "app.py"]
