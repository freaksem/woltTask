#Setup
Before run application wait for downloading dependencies by gradle.

For testing, you can run WoltApplication.kt and send post request to http://localhost:8080/api/schedule via Postman or something like this.

Or just run unit test from test folder.

#About data format.
For me this JSON structure looks ok in general.

If I could control the format, I would make it stricter:

Day has to have pairs 'open' and 'close' to simplify handling the data.

Adding time in human-readable format (for example 8 AM) allows us to avoid exceptions during transformation.