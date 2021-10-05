<template>
  <div class="home">
    <div v-show="this.$store.state.loggedIn === false">
      <img alt="Vue logo" src="../assets/logo.png">
      <v-form>
        <v-container>
          <v-row>
            <v-col
                cols="12"
                md="4"
            >
              <v-text-field
                  v-model="username"
                  label="Username"
                  required
              ></v-text-field>
            </v-col>

            <v-col
                cols="12"
                md="4"
            >
              <v-text-field
                  v-model="password"
                  :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                  :type="show ? 'text' : 'password'"
                  @click:append="show = !show"
                  label="Password"
                  required
              ></v-text-field>
            </v-col>

            <v-col
                cols="12"
                md="4"
            >
              <v-btn
                  class="mr-4"
                  @click="submit">
                Submit
              </v-btn>
            </v-col>
          </v-row>
        </v-container>
      </v-form>
    </div>
    <div v-show="this.$store.state.loggedIn === true">
      <h1>Youve been logged in</h1>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Home',
  data: () => ({
    show: false,
    username: '',
    password: '',
    jwt: '',
    signedIn: false,
    respdata: '',
  }),
  methods: {
    submit: async function () {
      const requestOptions = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username: this.username, password: this.password})
      };
      const response = await fetch("http://localhost:8080/api/login", requestOptions);
      let respData = await response.json();
      this.logIn(respData.loggedIn)
    },
    logIn(loginState) {
      this.$store.commit('changeLoginState', loginState)
      console.log("Logged in")
    }
  }
}
</script>
