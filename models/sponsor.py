# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

from odoo import models, fields, api

class sponsor(models.Model):
    _name = 'ofc_odoo.ofc_odoo'
    name = fields.Char(required = True)
    email = fields.Char()
    state = fields.Boolean()
    date = fields.Datetime()
    phone = fields.Integer()
    adType = fields.Selection()
    events = fields.Many2Many('ofc_odoo.event', string ="Events")
    admin = fields.Many2One('res.Users', required = True)
    
