#About data format.
For me this JSON structure looks ok in general.

If I could control the format, I would make it stricter:

Day has to have pairs 'open' and 'close' to simplify handling the data.

Adding time in human-readable format (for example 8 AM) allows us to avoid exceptions during transformation.