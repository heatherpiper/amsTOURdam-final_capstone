import axios from 'axios';

const AuthApi = axios.create({
  baseURL: 'http://localhost:8080'
});

export default {

  login(user) {
    return AuthApi.post('/login', user)
  },

  register(user) {
    return AuthApi.post('/register', user)
  }

}
