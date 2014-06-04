# petmimado.com website

The http://petmimado.com website, implemented as a generated static site using
[Stasis](https://github.com/magnars/stasis/) with frontend optimization using
[Optimus](https://github.com/magnars/optimus).


## Usage

To run the site, make sure you have Java 1.7 or later. Then install Leiningen. Finally, run the site with


```
lein ring server-headless
```

Or generate the static files for deployment with:


```
lein build-site
```


## License

Copyright © 2014 Cesar Canassa
