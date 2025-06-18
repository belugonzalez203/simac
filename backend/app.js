var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var cors = require('cors');

var indexRouter = require('./routes/index');
const techniciansRouter = require('./routes/technician');
const userRouter = require('./routes/user');
const areaRouter = require('./routes/area');
const equipmentRouter = require('./routes/equipment');
const sparePartRouter = require('./routes/sparePart');
const typeMaintenanceRouter = require('./routes/typeMaintenance');
const classMaintenanceRouter = require('./routes/classMaintenance');

var app = express();
app.use(cors());

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/', indexRouter);
app.use('/technician', techniciansRouter);
app.use('/user', userRouter);
app.use('/area', areaRouter);
app.use('/equipment', equipmentRouter);
app.use('/sparePart', sparePartRouter);
app.use('/typeMaintenance', typeMaintenanceRouter);
app.use('/classMaintenance', classMaintenanceRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

app.listen(3002, () => {
  console.log('Servidor corriendo en http://localhost:3002');
});

module.exports = app;
