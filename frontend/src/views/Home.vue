<template>
  <div class="home">
    <div v-show="this.$store.state.loggedIn === false">
      <img alt="smart home" src="../assets/undraw_smart_home_re_orvn.svg" width="50%"/>
      <v-row>
        <v-col>
          <v-form>
            <v-container>
              <h1>Log In</h1>
              <v-row>
                <v-col>
                  <v-text-field
                      v-model="username"
                      label="Username"
                      required
                  ></v-text-field>
                </v-col>
              </v-row>

              <v-row>
                <v-col>
                  <v-text-field
                      v-model="password"
                      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                      :type="show ? 'text' : 'password'"
                      @click:append="show = !show"
                      label="Password"
                      required
                  ></v-text-field>
                </v-col>
              </v-row>

              <v-row>
                <v-col>
                  <v-btn
                      class="mr-4"
                      @click="submit">
                    Submit
                  </v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-col>
        <v-col>
          <v-form>
            <v-container>
              <h1>Sign Up</h1>
              <v-row>
                <v-col>
                  <v-text-field
                      v-model="username"
                      label="Username"
                      required
                  ></v-text-field>
                </v-col>
              </v-row>

              <v-row>
                <v-col>
                  <v-text-field
                      v-model="password"
                      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                      :type="show ? 'text' : 'password'"
                      @click:append="show = !show"
                      label="Password"
                      required
                  ></v-text-field>
                </v-col>
              </v-row>

              <v-row>
                <v-col>
                  <v-btn
                      class="mr-4"
                      @click="submit">
                    Submit
                  </v-btn>
                </v-col>
              </v-row>
            </v-container>
          </v-form>
        </v-col>
      </v-row>
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

<style>
img {
  height: 15em;
}
</style>
